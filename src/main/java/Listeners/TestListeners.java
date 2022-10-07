package Listeners;


import org.testng.*;

import java.util.List;
import java.util.Set;

public class TestListeners implements ITestListener, ITestResult {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public void setStatus(int i) {

    }

    @Override
    public ITestNGMethod getMethod() {
        return null;
    }

    @Override
    public Object[] getParameters() {
        return new Object[0];
    }

    @Override
    public void setParameters(Object[] objects) {

    }

    @Override
    public IClass getTestClass() {
        return null;
    }

    @Override
    public Throwable getThrowable() {
        return null;
    }

    @Override
    public void setThrowable(Throwable throwable) {

    }

    @Override
    public long getStartMillis() {
        return 0;
    }

    @Override
    public long getEndMillis() {
        return 0;
    }

    @Override
    public void setEndMillis(long l) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public Object getInstance() {
        return null;
    }

    @Override
    public Object[] getFactoryParameters() {
        return new Object[0];
    }

    @Override
    public String getTestName() {
        return null;
    }

    @Override
    public String getInstanceName() {
        return null;
    }

    @Override
    public ITestContext getTestContext() {
        return null;
    }

    @Override
    public void setTestName(String s) {

    }

    @Override
    public boolean wasRetried() {
        return false;
    }

    @Override
    public void setWasRetried(boolean b) {

    }

    @Override
    public List<ITestNGMethod> getSkipCausedBy() {
        return ITestResult.super.getSkipCausedBy();
    }

    @Override
    public String id() {
        return null;
    }

    @Override
    public boolean isNotRunning() {
        return ITestResult.super.isNotRunning();
    }

    @Override
    public int compareTo(ITestResult o) {
        return 0;
    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public void setAttribute(String s, Object o) {

    }

    @Override
    public Set<String> getAttributeNames() {
        return null;
    }

    @Override
    public Object removeAttribute(String s) {
        return null;
    }
}
