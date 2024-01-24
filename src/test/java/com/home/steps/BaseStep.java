package com.home.steps;

public class BaseStep {
    protected static ThreadLocal<StepContext> stepContextThreadLocal = new ThreadLocal<StepContext>();

    public static StepContext getStepContextThreadLocal() {
        return stepContextThreadLocal.get();
    }

    public static void initContext() {
        stepContextThreadLocal.set(new StepContext());
    }
}
