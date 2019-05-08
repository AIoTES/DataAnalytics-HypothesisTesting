package eu.activage.services.testing;

import org.apache.commons.math3.stat.inference.TestUtils;

import eu.activage.services.web.rest.vm.TTestDataDesc;
import eu.activage.services.web.rest.vm.TTestHDataDesc;
import eu.activage.services.web.rest.vm.TTestOneSampleData;
import eu.activage.services.web.rest.vm.TTestOneSampleDataDesc;
import eu.activage.services.web.rest.vm.TTestOneSampleHDataDesc;
import eu.activage.services.web.rest.vm.TTestOptions;
import eu.activage.services.web.rest.vm.TTestHOptions;
import eu.activage.services.web.rest.vm.TTestSampleData;

/**
 * 
 * @author Yasar Khan
 *
 */
public class TTest {
	
	private double tStatistics;
	private double pValue;
	
	public TTest oneSampleT(TTestOneSampleDataDesc dataDesc) {
		
		TTestOneSampleData sampleData = dataDesc.getDataDesc();
		double[] sample = sampleData.getSample1();
		double compareToMean = sampleData.getCompareToMean();
		
		double tStatistics = TestUtils.t(compareToMean, sample);
		this.settStatistics(tStatistics);
		
		double pValue = TestUtils.tTest(compareToMean, sample);
		this.setpValue(pValue);
		
		return this;
	}
	
	
	public Boolean oneSampleTHypothesis(TTestOneSampleHDataDesc dataDesc) {
		
		TTestOneSampleData sampleData = dataDesc.getDataDesc();
		double[] sample = sampleData.getSample1();
		double compareToMean = sampleData.getCompareToMean();
		double alpha = dataDesc.getOptions().getAlpha();
		
		return TestUtils.tTest(compareToMean, sample, alpha);
	}
	
	
	public TTest twoSampleT(TTestDataDesc dataDesc) {
		
		TTestSampleData sampleData = dataDesc.getDataDesc();
		TTestOptions options = dataDesc.getOptions();
		String testType = options.gettTestType();
		
		double[] sample1 = sampleData.getSample1();
		double[] sample2 = sampleData.getSample2();
		
		if(testType.equalsIgnoreCase("paired")) {
			
			double tStatistics = TestUtils.pairedT(sample1, sample2);
			this.settStatistics(tStatistics);
			
			double pValue = TestUtils.pairedTTest(sample1, sample2);
			this.setpValue(pValue);
			
		} else if(testType.equalsIgnoreCase("unpaired")) {
			
			double tStatistics = TestUtils.t(sample1, sample2);
			this.settStatistics(tStatistics);
			
			double pValue = TestUtils.tTest(sample1, sample2);
			this.setpValue(pValue);
			
		}
		
		return this;
	}
	
	
	public Boolean twoSampleTHypothesis(TTestHDataDesc dataDesc) {
		
		Boolean rejectNullHypothesis = Boolean.FALSE;
		
		TTestSampleData sampleData = dataDesc.getDataDesc();
		TTestHOptions options = dataDesc.getOptions();
		String testType = options.gettTestType();
		double alpha = options.getAlpha();
		
		double[] sample1 = sampleData.getSample1();
		double[] sample2 = sampleData.getSample2();
		
		if(testType.equalsIgnoreCase("paired")) {
			
			rejectNullHypothesis = TestUtils.pairedTTest(sample1, sample2, alpha);
			
		} else if(testType.equalsIgnoreCase("unpaired")) {
			
			rejectNullHypothesis = TestUtils.tTest(sample1, sample2, alpha);
			
		}
		
		return rejectNullHypothesis;
	}
	
	
//	public TTest performTTest(TTestDataDesc dataDesc) {
//		
//		TTestSampleData sampleData = dataDesc.getDataDesc();
//		TTestOptions options = dataDesc.getOptions();
//		String query = dataDesc.getQuery();
//		double compareToMean = sampleData.getCompareToMean();
//		
//		String tTestType = options.gettTestType();
//		
//		if(tTestType.equalsIgnoreCase("OneSample")) {
//			
//			double[] sample = sampleData.getSample1();
//			
//			oneSampleTTest(sample, compareToMean);
//			
//		} else if(tTestType.equalsIgnoreCase("TwoSamplePaired")) {
//			
//			double[] sample1 = sampleData.getSample1();
//			double[] sample2 = sampleData.getSample2();
//			
//			twoSamplePairedTTest(sample1, sample2);
//			
//		} else if(tTestType.equalsIgnoreCase("TwoSampleUnpaired")) {
//			
//			double[] sample1 = sampleData.getSample1();
//			double[] sample2 = sampleData.getSample2();
//			
//			twoSampleUnpairedTTest(sample1, sample2);
//			
//		}
//		
//		return this;
//		
//	}
	
	
	
//	public Boolean performTTestHypothesis(TTestDataDesc dataDesc) {
//		
//		Boolean rejectNullHypothesis = Boolean.FALSE;
//		
//		TTestSampleData sampleData = dataDesc.getDataDesc();
//		TTestOptions options = dataDesc.getOptions();
//		String query = dataDesc.getQuery();
//		double compareToMean = sampleData.getCompareToMean();
//		
//		String tTestType = options.gettTestType();
//		double alpha = options.getAlpha();
//		
//		if(tTestType.equalsIgnoreCase("OneSample")) {
//			
//			double[] sample_1 = sampleData.getSample1();
//			
//			rejectNullHypothesis = TestUtils.tTest(compareToMean, sample_1, alpha);
//			
//		} else if(tTestType.equalsIgnoreCase("TwoSamplePaired")) {
//			
//			double[] sample_1 = sampleData.getSample1();
//			double[] sample_2 = sampleData.getSample2();
//			
//			rejectNullHypothesis = TestUtils.pairedTTest(sample_1, sample_2, alpha);
//			
//		} else if(tTestType.equalsIgnoreCase("TwoSampleUnpaired")) {
//			
//			double[] sample_1 = sampleData.getSample1();
//			double[] sample_2 = sampleData.getSample2();
//			
//			rejectNullHypothesis = TestUtils.tTest(sample_1, sample_2, alpha);
//			
//		}
//		
//		return rejectNullHypothesis;
//	}
	
	
//	private void oneSampleTTest(double[] sample, double mu) {
//		
//		double tStatistics = TestUtils.t(mu, sample);
//		this.settStatistics(tStatistics);
//		
//		double pValue = TestUtils.tTest(mu, sample);
//		this.setpValue(pValue);
//		
//	}
	
	
	
//	private void twoSampleUnpairedTTest(double[] sample1, double[] sample2) {
//		
//		double tStatistics = TestUtils.t(sample1, sample2);
//		this.settStatistics(tStatistics);
//		
//		double pValue = TestUtils.tTest(sample1, sample2);
//		this.setpValue(pValue);
//		
//	}
	
	
	
//	private void twoSamplePairedTTest(double[] sample1, double[] sample2) {
//		
//		double tStatistics = TestUtils.pairedT(sample1, sample2);
//		this.settStatistics(tStatistics);
//		
//		double pValue = TestUtils.pairedTTest(sample1, sample2);
//		this.setpValue(pValue);
//		
//	}
	
	
	
	
	public double gettStatistics() {
		return tStatistics;
	}


	public void settStatistics(double tStatistics) {
		this.tStatistics = tStatistics;
	}


	public double getpValue() {
		return pValue;
	}


	public void setpValue(double pValue) {
		this.pValue = pValue;
	}


//	public static void main(String args[]) {
//		
//		TTest tTest = new TTest();
//		
//		/**
//		 * One sample T Test
//		 */
//		double[] sample = {1d, 2d, 3d};
//		double mu = 2.5d;
//		
//		
//		tTest.oneSampleTTest(sample, mu);
//		
//		/**
//		 * Two sample Unpaired T Test 
//		 */
//		double[] sample1 = {22.3,25.4,21.7,20.9,25.1,23.8,24.2,23.0,26.8,24.3,22.2,23.4,25.7,24.7,22.7,23.8,24.9,24.7,26.9,23.3,24.6,23.5,25.4,23.6,24.1,25.2,24.6,27.4,24.4,23.6};
//		double[] sample2 = {15.4,20.2,14.6,13.2,16.7,18.9,16.9,18.6,19.5,14.6,15.9,19.3,16.8,16.6,18.5,17.4,16.8,15.3,13.9,16.3,14.7,18.6,18.5,15.3,17.7,19.0,17.8,16.3,18.3,15.8};
//		
//		tTest.twoSampleUnpairedTTest(sample1, sample2);
//		
//		System.out.println("[Two Sample unpaired] t-statistics = " + this.tStatistics);
//		System.out.println("[Two Sample unpaired] p-value = " + pValue);
//		
//		/**
//		 * Two sample Paired T Test 
//		 */
//		double[] sample3 = {101,124,89,57,135,98,69,105,114,106,97,121,93,116,102,71,88,108,144,99};
//		double[] sample4 = {113,127,89,70,127,104,69,127,115,99,104,120,95,129,106,71,94,112,154,96};
//		
//		
//		tTest.twoSamplePairedTTest(sample3, sample4);
//		
//		System.out.println("[Two Sample Paired] t-statistics = " + tStatistics);
//		System.out.println("[Two Sample Paired] p-value = " + pValue);
//		
//		
//	}
	
	

}
