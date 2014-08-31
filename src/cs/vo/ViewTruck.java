package cs.vo;

public class ViewTruck {
	private int truckId;
	private float truckLength;
	private String truckType;
	private Integer trayCount;
	private Integer bulkCount;
	public Integer getTrayCount() {
		return trayCount;
	}
	public void setTrayCount(Integer trayCount) {
		this.trayCount = trayCount;
	}
	public Integer getBulkCount() {
		return bulkCount;
	}
	public void setBulkCount(Integer bulkCount) {
		this.bulkCount = bulkCount;
	}
	public int getTruckId() {
		return truckId;
	}
	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}
	public float getTruckLength() {
		return truckLength;
	}
	public void setTruckLength(float truckLength) {
		this.truckLength = truckLength;
	}
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

}
