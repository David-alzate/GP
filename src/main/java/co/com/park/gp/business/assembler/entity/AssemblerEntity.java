package co.com.park.gp.business.assembler.entity;

import co.com.park.gp.business.assembler.Assembler;

public interface AssemblerEntity<D,K> extends Assembler<D, K> {
	
	K toEntity(D domain);

}