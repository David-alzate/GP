package co.com.park.gp.business.assembler.dto;

import co.com.park.gp.business.assembler.Assembler;

public interface AssemblerDTO<D, K> extends Assembler<D, K>{
	
	K toDto(D domain);

}

