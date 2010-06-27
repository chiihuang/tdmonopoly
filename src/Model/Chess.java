package Model;

public interface Chess
{
	/*
	 * 只要有implements Chess這個interface的class，
	 * 都將會有 getIcon 這個功能。
	 * 所以，像是Tower Human Computer，
	 * 若不是abstract的話，
	 * 都要把這些method實作出來。
	 */
	String getIcon();//物件圖檔
	String getOwner();//玩家名稱或所屬玩家名稱
	java.awt.Color getColor();//顏色
}
