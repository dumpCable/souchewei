package souchewei.park.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity()
@Table(name="park")
public class Park implements Serializable{
	@Id @Column(name="park_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long parkId;
	private String location;				//停车场位置
	private String name;					//停车场名字
	private String area;					//停车场所在地址
	private String type;					//停车场类型（室内，室外）
	private Double latitude;				//纬度
	private Double longitude;				//经度
	private Integer parkingNumber;			//停车场车位数量
	@OneToMany(targetEntity=ParkingPlace.class,
		mappedBy="park")
	private Set<ParkingPlace> parkingPlaces;//所拥有车位的具体情况
	public Long getParkId() {
		return parkId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getParkingNumber() {
		return parkingNumber;
	}
	public void setParkingNumber(Integer parkingNumber) {
		this.parkingNumber = parkingNumber;
	}
	public Set<ParkingPlace> getParkingPlaces() {
		return parkingPlaces;
	}
	public void setParkingPlaces(Set<ParkingPlace> parkingPlaces) {
		this.parkingPlaces = parkingPlaces;
	}
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass().equals(Park.class)){
			Park target = (Park)o;
			return target.getParkId().equals(this.parkId);
		}
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 17;
		if(this.parkId != null){
			hash = hash * 31 + this.parkId.hashCode();
		}
		return hash;
	}
}
