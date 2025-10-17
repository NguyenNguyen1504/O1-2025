package o1.carsim

import scala.math.*
import o1.Pos


class Car(val fuelConsumption: Double, val tankSize: Double, initialFuel: Double, initialLocation: Pos):

  private var currentLocation = this.initialLocation
  private var currentFuel = this.initialFuel
  private var drivenDistance = 0.0

  def location: Pos = this.currentLocation

  def fuel(toBeAdded: Double): Double =
    val fuelBeforeAdded = this.currentFuel
    this.currentFuel = min(this.currentFuel + toBeAdded, this.tankSize)
    this.currentFuel - fuelBeforeAdded

  def fuel(): Double = this.fuel(this.tankSize - this.currentFuel)

  def fuelRatio: Double = this.currentFuel / this.tankSize * 100.0

  def metersDriven: Double = this.drivenDistance

  def fuelRange: Double = this.currentFuel / this.fuelConsumption * 100000.0

  def drive(destination: Pos, metersToDestination: Double): Unit =
    val possibleRange = min(fuelRange, metersToDestination)
    val possibleDestination =
      val rangeRatio = possibleRange / metersToDestination
      val rangeX = this.currentLocation.xDiff(destination)
      val rangeY = this.currentLocation.yDiff(destination)
      if possibleRange < metersToDestination then
        this.currentLocation.add(rangeRatio * rangeX, rangeRatio * rangeY)
      else
        destination
    this.currentLocation = possibleDestination
    this.drivenDistance += possibleRange
    this.currentFuel -= possibleRange * this.fuelConsumption / 100000.0

end Car

