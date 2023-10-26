package trackia.app.example.calc.multiplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.example.calc.multiplication.service.MultiplicationService;
import trackia.app.example.calc.multiplication.to.CalcRequest;
import trackia.app.example.calc.multiplication.to.CalcResponse;
import trackia.app.module.sla.Slable;
import trackia.app.module.sysinfo.Infoable;

@RestController
@AllArgsConstructor
@Log4j2
public class MultiplicationController {
	
	private final MultiplicationService service;
	
	@Trackia(
      description = "Calc Multiplication TrackIA example",
  		  	write = true
	)
	@Slable(3000)
	@Infoable
	
	@PostMapping("multiplication")
	public ResponseEntity<CalcResponse> multiplication(@Validated @RequestBody CalcRequest request) {
		log.info("multiplication start");
		return new ResponseEntity<>(service.calc(request), HttpStatus.OK);
	}
}
