package com.opitzconsulting.bwertr.spec;

import org.concordion.api.ResultSummary;
import org.concordion.internal.ConcordionBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public abstract class AbstractBwertrSpec {

    protected final BwertrDriver bwertrDriver = new BwertrDriver();

    @BeforeClass
    public static void extendConcordion() {
        System.setProperty("concordion.output.dir", "target/concordion");
    }

    @Test
    @SuppressWarnings({"UnusedDeclaration"})
    public final void runConcordion() throws IOException {
        ResultSummary summary = new ConcordionBuilder().build().process(this);
        summary.print(System.out, this);
        summary.assertIsSatisfied(this);
    }

}