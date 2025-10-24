package com.javaevolution.moduleimport;

import com.javaevolution.moduleimport.ModuleImportExample.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModuleImportExampleTest {

    @Test
    void traditionalImportStyle_shouldWork() {
        TraditionalImportStyle example = new TraditionalImportStyle();
        String result = example.demonstrateCollections();
        assertEquals("Collections created", result);
    }

    @Test
    void moduleImportStyle_shouldDemonstrateConcept() {
        ModuleImportStyle example = new ModuleImportStyle();
        String result = example.demonstrateWithModuleImport();
        assertTrue(result.contains("module-level"));
    }

    @Test
    void largeProjectExample_shouldShowBenefit() {
        LargeProjectExample example = new LargeProjectExample();
        String result = example.processWithModuleServices();
        assertTrue(result.contains("services"));
    }

    @Test
    void scopeExample_shouldDemonstrateEncapsulation() {
        ScopeExample example = new ScopeExample();
        String result = example.demonstrateEncapsulation();
        assertTrue(result.contains("boundaries"));
    }

    @Test
    void hybridImportExample_shouldCombineStyles() {
        HybridImportExample example = new HybridImportExample();
        String result = example.demonstrateHybridImports();
        assertTrue(result.contains("traditional"));
    }

    @Test
    void toolingExample_shouldDescribeSupport() {
        ToolingExample example = new ToolingExample();
        String result = example.demonstrateToolingSupport();
        assertTrue(result.contains("IDE"));
    }

    @Test
    void migrationExample_shouldDescribeStrategy() {
        MigrationExample example = new MigrationExample();
        String result = example.demonstrateMigration();
        assertTrue(result.contains("migration"));
    }

    @Test
    void transitiveDependencyExample_shouldExplainTransitive() {
        TransitiveDependencyExample example = new TransitiveDependencyExample();
        String result = example.demonstrateTransitive();
        assertTrue(result.contains("transitive"));
    }

    @Test
    void conflictResolutionExample_shouldHandleConflicts() {
        ConflictResolutionExample example = new ConflictResolutionExample();
        String result = example.demonstrateConflictResolution();
        assertTrue(result.contains("qualified"));
    }

    @Test
    void performanceExample_shouldDescribePerformance() {
        PerformanceExample example = new PerformanceExample();
        String result = example.demonstratePerformance();
        assertTrue(result.contains("performance"));
    }
}
