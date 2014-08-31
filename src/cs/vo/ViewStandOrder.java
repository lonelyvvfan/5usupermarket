package cs.vo;

public class ViewStandOrder {
	private int sorderId;
	private Integer trayCount;
	private Float loadingTime;
	private Float uninstallTime;
	private Float forkliftTruckTime;
	private Float platformTime;
	private int iorderId;
	private String orderDate;
	private String orderSP;
	private String destination;
	private String carnumber;
	private String selfcode;
	private String cigarette;
	private int quantity;
	public int getSorderId() {
		return sorderId;
	}
	public void setSorderId(int sorderId) {
		this.sorderId = sorderId;
	}
	public Integer getTrayCount() {
		return trayCount;
	}
	public void setTrayCount(Integer trayCount) {
		this.trayCount = trayCount;
	}
	public Float getLoadingTime() {
		return loadingTime;
	}
	public void setLoadingTime(Float loadingTime) {
		this.loadingTime = loadingTime;
	}
	public Float getUninstallTime() {
		return uninstallTime;
	}
	public void setUninstallTime(Float uninstallTime) {
		this.uninstallTime = uninstallTime;
	}
	public Float getForkliftTruckTime() {
		return forkliftTruckTime;
	}
	public void setForkliftTruckTime(Float forkliftTruckTime) {
		this.forkliftTruckTime = forkliftTruckTime;
	}
	public Float getPlatformTime() {
		return platformTime;
	}
	public void setPlatformTime(Float platformTime) {
		this.platformTime = platformTime;
	}
	public int getIorderId() {
		return iorderId;
	}
	public void setIorderId(int iorderId) {
		this.iorderId = iorderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderSP() {
		return orderSP;
	}
	public void setOrderSP(String orderSP) {
		this.orderSP = orderSP;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getSelfcode() {
		return selfcode;
	}
	public void setSelfcode(String selfcode) {
		this.selfcode = selfcode;
	}
	public String getCigarette() {
		return cigarette;
	}
	public void setCigarette(String cigarette) {
		this.cigarette = cigarette;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
