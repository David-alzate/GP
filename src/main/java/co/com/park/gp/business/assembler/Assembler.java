package co.com.park.gp.business.assembler;

public interface Assembler <D, K> {
	
	D toDomain(K data);
}