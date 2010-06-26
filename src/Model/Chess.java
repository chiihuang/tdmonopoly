package Model;

public interface Chess
{
	/*
	 * 只要有implements Chess這個interface的class，
	 * 都將會有 getIcon 這個功能。
	 * 所以，像是Tower Human Computer，
	 * 若不是abstract的話，
	 * 都要把getIcon這個method實作出來。
	 */
	String getIcon();
}
