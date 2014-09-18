package views;

import utils.Constants.AggregateFunctions;


public class AggregateValuesWrapper {
	public class AggregateValues {
		public double count;
		public double sum;
		public double average;
		
		public AggregateValues() {
			
		}
		
		public AggregateValues(double count, double sum, double average) {
			this.count = count;
			this.sum = sum;
			this.average = average;
		}
		
		public double getValue(AggregateFunctions func) {
			switch (func) {
			case COUNT:
				return count;
			case SUM:
				return sum;
			case AVG:
				return average;
			}
			return -1;
		}
	}
	public AggregateValues datasetValues[] = {new AggregateValues(), new AggregateValues()};
	
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof AggregateValuesWrapper)) {
			return false;
		}
		AggregateValuesWrapper o_ = (AggregateValuesWrapper) o;
		for (int i = 0 ; i < datasetValues.length; i++) {
			if ((Math.abs(o_.datasetValues[i].count - this.datasetValues[i].count) > 0.01) || 
			    (Math.abs(o_.datasetValues[i].sum - this.datasetValues[i].sum) > 0.01) || 
			    (Math.abs(o_.datasetValues[i].average - this.datasetValues[i].average) > 0.01)) {
				return false;
			}
		}
		return true;
	}
}