package _10

object Peaks {
  def hasPeakInEachBlock(peaks: Seq[Boolean])(blockSize: Int): Boolean =
    peaks.grouped(blockSize)
      .map(_.contains(true))
      .forall(_ == true)

  def solution(hills: Array[Int]): Int = {
    val peaks = Flags.findPeaks(hills)
    val peaksLength = peaks.length

    val numPeaks = peaks.count(_ == true)
    val blocks = MinPerimeterRectangle.generateFactors(peaksLength)

    if (numPeaks == 0) 0
    else {
      val blockSizes = blocks.filter(_ >= peaksLength / numPeaks).toStream
      val smallestFitting = blockSizes
        .map(hasPeakInEachBlock(peaks))
        .takeWhile(_ == false).length

      peaksLength / blockSizes(smallestFitting)
    }
  }
}
