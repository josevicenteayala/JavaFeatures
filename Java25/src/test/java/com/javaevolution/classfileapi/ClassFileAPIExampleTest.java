package com.javaevolution.classfileapi;

import com.javaevolution.classfileapi.ClassFileAPIExample.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassFileAPIExampleTest {

    @Test
    void classFileReader_shouldReadClassInfo() {
        ClassFileReader reader = new ClassFileReader();
        byte[] dummyBytes = new byte[0];
        ClassFileReader.ClassInfo info = reader.readClassFile(dummyBytes);
        
        assertNotNull(info);
        assertEquals("ExampleClass", info.name());
        assertEquals(65, info.version());
    }

    @Test
    void classFileReader_shouldDescribeClass() {
        ClassFileReader reader = new ClassFileReader();
        ClassFileReader.ClassInfo info = new ClassFileReader.ClassInfo("Test", 65, 5);
        String description = reader.describeClass(info);
        
        assertTrue(description.contains("Test"));
        assertTrue(description.contains("65"));
    }

    @Test
    void methodInspector_shouldInspectStaticMethod() {
        MethodInspector inspector = new MethodInspector();
        MethodInspector.MethodInfo method = new MethodInspector.MethodInfo("main", "([Ljava/lang/String;)V", true);
        String result = inspector.inspectMethod(method);
        
        assertTrue(result.contains("static"));
        assertTrue(result.contains("main"));
    }

    @Test
    void classGenerator_shouldGenerateClass() {
        ClassGenerator generator = new ClassGenerator();
        ClassGenerator.GeneratedClassInfo info = generator.generateSimpleClass();
        
        assertEquals("GeneratedClass", info.name());
        assertEquals("hello", info.methodName());
    }

    @Test
    void classTransformer_shouldTransform() {
        ClassTransformer transformer = new ClassTransformer();
        String result = transformer.transformClass("TestClass");
        assertTrue(result.contains("Transformed"));
    }

    @Test
    void instrumentor_shouldInstrument() {
        Instrumentor instrumentor = new Instrumentor();
        String result = instrumentor.instrumentMethod("testMethod");
        assertTrue(result.contains("instrumentation"));
    }

    @Test
    void attributeHandler_shouldHandleAttribute() {
        AttributeHandler handler = new AttributeHandler();
        AttributeHandler.AttributeInfo attr = new AttributeHandler.AttributeInfo("Code", 100);
        String result = handler.handleAttribute(attr);
        
        assertTrue(result.contains("Code"));
        assertTrue(result.contains("100"));
    }

    @Test
    void constantPoolHandler_shouldProcess() {
        ConstantPoolHandler handler = new ConstantPoolHandler();
        String result = handler.processConstantPool();
        assertTrue(result.contains("constant pool"));
    }

    @Test
    void stackMapHandler_shouldGenerate() {
        StackMapHandler handler = new StackMapHandler();
        String result = handler.generateStackMaps();
        assertTrue(result.contains("Stack map") || result.contains("stack map"));
    }

    @Test
    void useCases_shouldDescribeUseCase() {
        UseCases useCases = new UseCases();
        String result = useCases.describeDUseCase("Testing");
        assertTrue(result.contains("Testing"));
    }
}
