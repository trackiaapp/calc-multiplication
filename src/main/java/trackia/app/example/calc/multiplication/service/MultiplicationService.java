package trackia.app.example.calc.multiplication.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.example.calc.multiplication.dao.MultiplicationDao;
import trackia.app.example.calc.multiplication.to.CalcRequest;
import trackia.app.example.calc.multiplication.to.CalcResponse;

@Service
@AllArgsConstructor
@Log4j2
public class MultiplicationService {
	private final MultiplicationDao dao;
	
	@Trackia(value = "MULTIPLICATION_SERVICE", description = "Multiplication logic")
	public CalcResponse calc(CalcRequest request){
		log.info("calc start");
		
		return dao.calc(request.getLeft(), request.getRight());
	}
}
