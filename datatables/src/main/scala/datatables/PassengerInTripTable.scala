package datatables

import java.time.{LocalDate, LocalTime}

import slick.jdbc.PostgresProfile.api._

class PassengerInTripTable(tag: Tag) extends Table[model.PassengerInTrip](tag, "Pass_in_trip") {
  val tripId = column[Int]("trip_no", O.PrimaryKey)
  val passengerId = column[Int]("ID_psg", O.PrimaryKey)
  val date = column[LocalDate]("datetime", O.PrimaryKey)
  val place = column[Int]("place")

  val TripIdForeignKey = foreignKey("tripId_FK",tripId, TripTable.table)(_.id, ForeignKeyAction.Cascade, ForeignKeyAction.Cascade)

  val PassengerIdForeignKey = foreignKey("passengerId_FK", passengerId, PassengerTable.table)(_.id, ForeignKeyAction.Cascade, ForeignKeyAction.Cascade)

  def * = (tripId, passengerId, date, place).mapTo[model.PassengerInTrip]

}

object PassengerInTripTable{
  val table = TableQuery[PassengerInTripTable]
}