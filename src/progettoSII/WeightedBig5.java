package progettoSII;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

public class WeightedBig5 {
	
	public Double[] assignWeight(Map<String, Integer> w, Map<String, Double[]> big5) {
		Double[] weighted = new Double[5];
		Iterator<String> iter = big5.keySet().iterator();
		double ext = 0;
		double neu = 0;
		double agr = 0;
		double con = 0;
		double opn = 0;
		double weight = 0;
		
		while (iter.hasNext()) {
			String key = iter.next();
			double val1 = big5.get(key)[0];
			double val2 = big5.get(key)[1];
			double val3 = big5.get(key)[2];
			double val4 = big5.get(key)[3];
			double val5 = big5.get(key)[4];
			
			if (val1==3.75 && val2==2.00 && val3==5.00 && val4==4.25 && val5==4.50) {
				final double defaultWeight = 0.1;
				ext += val1*defaultWeight;
				neu += val2*defaultWeight;
				agr += val3*defaultWeight;
				con += val4*defaultWeight;
				opn += val5*defaultWeight;
				weight += defaultWeight;
			}
			else if (val1==4.5 && val2==4.00 && val3==3.00 && val4==4.50 && val5==3.75) {
					final double defaultWeight = 0.2;
					ext += val1*defaultWeight;
					neu += val2*defaultWeight;
					agr += val3*defaultWeight;
					con += val4*defaultWeight;
					opn += val5*defaultWeight;
					weight += defaultWeight;
				}
			else {
				ext += val1*w.get(key);
				neu += val2*w.get(key);
				agr += val3*w.get(key);
				con += val4*w.get(key);
				opn += val5*w.get(key);
				weight += w.get(key);
			}
		}
		
		BigDecimal v1 = java.math.BigDecimal.valueOf(ext/weight).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal v2 = java.math.BigDecimal.valueOf(neu/weight).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal v3 = java.math.BigDecimal.valueOf(agr/weight).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal v4 = java.math.BigDecimal.valueOf(con/weight).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal v5 = java.math.BigDecimal.valueOf(opn/weight).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		weighted[0] = v1.doubleValue()*100/5;
		weighted[1] = v2.doubleValue()*100/5;
		weighted[2] = v3.doubleValue()*100/5;
		weighted[3] = v4.doubleValue()*100/5;
		weighted[4] = v5.doubleValue()*100/5;
	
		return weighted;
	}
}
