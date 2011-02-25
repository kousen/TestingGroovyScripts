package mjg.scripts

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ScriptTests {
    GroovyShell shell
    Binding binding
    StringWriter content
    
    @Before
    void setUp() {
        content = new StringWriter()
        binding = new Binding()
        binding.out = new PrintWriter(content)
        shell = new GroovyShell(binding)
    }
    
    @Test
    void testScriptWithAssert() {
        shell.evaluate(new File("src/mjg/scripts/script_with_assert.groovy"))
    }

    @Test
    void testScriptWithTrueVariable() {
        binding.ok = true
        shell.evaluate(new File("src/mjg/scripts/script_with_variable.groovy"))
        assertTrue shell.ok
    }

    @Test
    void testScriptWithFalseVariable() {
        binding.ok = false
        shell.evaluate(new File("src/mjg/scripts/script_with_variable.groovy"))
        assertFalse shell.ok
    }

    @Test
    void testHelloWorld() {
        shell.evaluate(new File("src/mjg/scripts/hello_world.groovy"))
        assertEquals "Hello, World!", content.toString().trim()
    }    
    
}
