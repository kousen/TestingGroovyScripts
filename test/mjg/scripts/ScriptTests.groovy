package mjg.scripts

import static org.junit.Assert.*

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class ScriptTests {
    GroovyShell shell
    Binding binding
    PrintStream orig
    ByteArrayOutputStream out
    
    @Before
    void setUp() {
        orig = System.out
        out = new ByteArrayOutputStream()
        System.setOut(new PrintStream(out))
        binding = new Binding()
        shell = new GroovyShell(binding)
    }
    
    @After
    void tearDown() {
        System.setOut(orig)
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
        assertEquals "Hello, World!", out.toString().trim()
    }    
    
}
