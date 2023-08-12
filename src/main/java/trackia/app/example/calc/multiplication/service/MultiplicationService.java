package trackia.app.example.calc.multiplication.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.annotations.R;
import trackia.app.example.calc.multiplication.dao.MultiplicationDao;
import trackia.app.example.calc.multiplication.to.CalcRequest;
import trackia.app.example.calc.multiplication.to.CalcResponse;
import trackia.app.to.Journal;

@Service
@AllArgsConstructor
@Log4j2
public class MultiplicationService {
	private final MultiplicationDao dao;
	
	@Trackia(value = "MULTIPLICATION_SERVICE", description = "Multiplication logic")
	public CalcResponse calc(@R CalcRequest request, Journal journal){
		log.info("calc start");
		
		return dao.calc(request.getLeft(), request.getRight(), journal);
	}
}
