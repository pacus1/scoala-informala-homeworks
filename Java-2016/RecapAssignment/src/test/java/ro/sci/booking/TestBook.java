package ro.sci.booking;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.joda.time.DateTimeComparator;
import org.junit.Before;

import ro.sci.booking.exception.BookingPeriodValidationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
/*
 * Before 
 * 		init booking (Accommodation and BookingPeriod) 
 * 		init new booking data
 * 		set a bookNewRoom method
 * 			- check if the new booking data overlaps the existing one
 * 			- add the new booking data to booking
 * 
 */
public class TestBook {

	List<Accommodation> rooms;

	List<BookingPeriod> periods;

	List<Booking> bookings;
	
	Boolean bookedOk; 

	@Before
	public void init() {	
		
		rooms = new ArrayList<Accommodation>();
		Date from = getDate(2016, 5, 1);
		Date to = getDate(2016, 8, 27);
		
		Season season = createSeason(SeasonType.HIGH, from, to);
		RoomFair roomFair1 = createRoomFair(100, season);

		Accommodation room1 = createNewRoom(AccommodationType.ROYAL, roomFair1);
		rooms.add(room1);
		
		periods = new ArrayList<BookingPeriod>();

		periods.add(new BookingPeriod(getDate(2016, 5, 12), getDate(2016, 5, 17)));
		periods.add(new BookingPeriod(getDate(2016, 6, 10), getDate(2016, 6, 13)));
		periods.add(new BookingPeriod(getDate(2016, 7, 5), getDate(2016, 7, 12)));
		periods.add(new BookingPeriod(getDate(2016, 8, 2), getDate(2016, 8, 4)));
		
		bookings = new ArrayList<Booking>();
		
		for(BookingPeriod bookPeriod: periods){
			bookings.add(new Booking(room1, bookPeriod));
		}
	}		
	
	@Test //test booking available period
	public void testBookingPOzitive(){
		Date bookFrom = getDate(2016,5,20);
		Date bookTo = getDate(2016,5,25);
		
		BookingPeriod testBookDate = new BookingPeriod(bookFrom, bookTo);
		BookingPeriod resultBookDate = null;
	
		assertTrue(bookRoom(AccommodationType.ROYAL,testBookDate));//checks if the date requested date is found available
		
		resultBookDate = bookings.get(4).getBookingPeriod();
		
		assertEquals(bookings.get(4).getBookingPeriod(),testBookDate);//checks if the booking is actually written in Booking
	}

	@Test //test booking unavailable period
	public void testBookingNegative(){
		Date bookFrom = getDate(2016,5,10);
		Date bookTo = getDate(2016,5,15);
		
		BookingPeriod testBookDate = new BookingPeriod(bookFrom, bookTo);
	
		assertFalse(bookRoom(AccommodationType.ROYAL,testBookDate)); //checks if the date requested date is not found available
	}
	
	@Test //test cancel booking existing period
	public void testCancelBookingExisting(){
		Date bookFrom = getDate(2016,6,10);
		Date bookTo = getDate(2016,6,13);
		BookingPeriod testBookDate = new BookingPeriod(bookFrom, bookTo);
		BookingPeriod resultBookDate = null;
		
		assertTrue(cancelBooking(AccommodationType.ROYAL,testBookDate)); //checks if the cancelBooking method returns true means period to be canceled was found
		
		assertTrue(bookRoom(AccommodationType.ROYAL,testBookDate));//checks if the date requested date is found available
	}
	
	@Test //test cancel booking non-existing period
	public void testCancelBookingNonExisting(){
		Date bookFrom = getDate(2016,6,11);
		Date bookTo = getDate(2016,6,13);
		
		BookingPeriod testBookDate = new BookingPeriod(bookFrom, bookTo);
		
		assertFalse(cancelBooking(AccommodationType.ROYAL,testBookDate)); //checks if the cancelBooking method returns true means period to be canceled was found
	}
	
	private Accommodation createNewRoom(AccommodationType type, RoomFair fair) {
		Accommodation accomodation = new Accommodation();
		accomodation.setType(type);
		accomodation.setFair(fair);
		return accomodation;
	}

	private RoomFair createRoomFair(int i, Season season) {
		RoomFair roomFair = new RoomFair();
		roomFair.setSeason(season);
		roomFair.setValue(i);
		return roomFair;
	}

	private Season createSeason(SeasonType type, Date from, Date to) {
		Season season = new Season();
		season.setFrom(from);
		season.setTo(to);
		season.setType(type);
		return season;
	}

	private Date getDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);

		return c.getTime();
	}
	
	public boolean bookRoom(AccommodationType roomType, BookingPeriod bookingPeriod){
		boolean found = false;
		Accommodation room2 = rooms.get(0);	
		
		for (Booking booking : bookings) {
			found = booking.getRoom().getType().equals(roomType) && booking.getBookingPeriod().getFrom().before(bookingPeriod.getFrom())
					&& booking.getBookingPeriod().getTo().after(bookingPeriod.getFrom());
			if (found)
				return false;
			
			found = booking.getRoom().getType().equals(roomType) && booking.getBookingPeriod().getFrom().before(bookingPeriod.getTo())
					&& booking.getBookingPeriod().getTo().after(bookingPeriod.getTo());
			if (found)
				return false;
		}
		
		bookings.add(new Booking( room2, bookingPeriod));
		return true;
	}	
	
	public boolean cancelBooking(AccommodationType roomType, BookingPeriod bookingPeriod){
		
		boolean found = false;
		int testEqualDate;
		DateTimeComparator dtComp = DateTimeComparator.getDateOnlyInstance();
		
		for (Booking booking : bookings) {
			
			found = booking.getRoom().getType().equals(roomType);	
	
			testEqualDate = dtComp.compare(booking.getBookingPeriod().getFrom(),bookingPeriod.getFrom()) + dtComp.compare(booking.getBookingPeriod().getTo(),bookingPeriod.getTo());
			
			if (found && testEqualDate == 0){
				bookings.remove(booking);
				return true;
			}
		}
		
		return false;
	}
	
}
