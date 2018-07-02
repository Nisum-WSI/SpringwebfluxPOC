package com.nisum.springwebfluxpoc;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxController {
	
	@Autowired
	private WebFluxRepo webFluxRepo;

	@PostMapping(value="/saveScore")
	Mono<Score> saveScore(@RequestBody Score score){
		System.out.println(score.toString());
		return webFluxRepo.save(score);
		/*Score score1 = webFluxRepo.save(score);
		return Mono.just(score1);*/
	}
	
	@GetMapping(value="/getScore/{id}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<Object> getScore(@PathVariable("id") Long id){
		Flux<Long> duration = Flux.interval(Duration.ofSeconds(10));
		return Flux.zip(Flux.fromStream(Stream.generate(()-> webFluxRepo.findById(id))), duration).map(s -> s.getT1()).repeat().map(n -> n);
	}
	
	@GetMapping(value="/getScore", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<Object> getAllScore( ){
		Flux<Long> duration = Flux.interval(Duration.ofSeconds(1));
		//return webFluxRepo.findAll().repeat(2).map(n->n);
		
		//return webFluxRepo.findAll();
	return Flux.zip(webFluxRepo.findAll(), duration).map(data -> data.getT1()).repeat().map(n -> n);	
		
	//	return Flux.zip(Flux.fromStream(Stream.generate(()-> webFluxRepo.findAll())), duration).map(s -> s.getT1()).repeat().map(n -> n);
		
	}
	

	@DeleteMapping(value="/deleteScore/{id}")
	Mono<Void> deleteCustomerProfile(@PathVariable("id") Long id){	
		webFluxRepo.deleteById(id);
		return null;
}
	@GetMapping(value="/findAll", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<Object> findAll() {
	  /*   Flux.interval(Duration.ofSeconds(1))
	            .takeWhile(i -> i < 2)
	            .map(i -> i.intValue() + 1)
	            .map(n->n);*/
	    return Flux.zip(Flux.fromStream(Stream.generate(()-> webFluxRepo.findAll())), Flux.interval(Duration.ofSeconds(1))
	            .takeWhile(i -> i < 2)).map(s -> s.getT1()).repeat().map(n -> n);

	}
/*
	@GetMapping(value="/test", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<Object> test( ){
		Flux<Long> duration = Flux.interval(Duration.ofSeconds(10));
		Flux<Long> duratio1=Flux.buffer(2);
		return Flux.zip(Flux.fromStream(Stream.generate(()-> webFluxRepo.findAll())),  ).map(s -> s.getT1()).repeat().map(n -> n);
	}*/
	
	
}
