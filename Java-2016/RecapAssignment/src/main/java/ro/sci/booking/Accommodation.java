package ro.sci.booking;

public class Accommodation {
	private AccommodationType type;
	private String description;
	private int maxGuests;

	public Accommodation() {
		super();
	}

	public Accommodation(AccommodationType type, String description, int maxGuests, BedType bedType, RoomFair fair) {
		super();
		this.type = type;
		this.description = description;
		this.maxGuests = maxGuests;
		this.bedType = bedType;
		this.fair = fair;
	}

	public Accommodation(AccommodationType type, BedType bedType) {
		super();
		this.type = type;
		this.bedType = bedType;
	}

	private BedType bedType;
	private RoomFair fair;

	public AccommodationType getType() {
		return type;
	}

	public void setType(AccommodationType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

	public BedType getBedType() {
		return bedType;
	}

	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}

	public RoomFair getFair() {
		return fair;
	}

	public void setFair(RoomFair fair) {
		this.fair = fair;
	}

}
