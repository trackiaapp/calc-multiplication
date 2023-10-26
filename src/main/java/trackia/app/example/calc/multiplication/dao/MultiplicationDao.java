package trackia.app.example.calc.multiplication.dao;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.example.calc.multiplication.to.CalcResponse;
import trackia.app.util.TrackiaTransactionTrace;

@Repository
@AllArgsConstructor
@Log4j2
public class MultiplicationDao {
	private final CalcDao calcDao;
	@Trackia(value = "DAO_CALC", description = "Multiplication calc")
	public CalcResponse calc(Object left, Object right) {
		log.info("calc start");
		return new CalcResponse(calcDao.value(left, "left") * 
				                calcDao.value(right, "right"), 
				                TrackiaTransactionTrace.getTransactionId());
	}
	

}
