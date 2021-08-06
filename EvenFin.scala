import scala.annotation.tailrec
import scala.io.Source

object EvenFin   {

  case class MinBox (minX:Int, minY:Int, maxX:Int, maxY:Int)

  def overlap(box1: MinBox, box2: MinBox):Boolean = {
    val checkRight = box1.maxX > box2.minX && box1.maxX < box2.maxX
    val checkLeft = box1.minX > box2.minX && box1.minX < box2.maxX
    val checkTop = box1.minY > box2.minY && box1.minY < box2.maxY
    val checkBottom = box1.maxY > box2.minY && box1.maxY < box2.maxY
    (checkTop && checkRight) || (checkTop && checkLeft) || (checkBottom && checkRight) || (checkBottom && checkLeft)
  }


  private def deleteOverlap(boxList: List[MinBox]):List[MinBox]={
    val overlapList = boxList.combinations(2).filter(tup => overlap(tup.head,tup(1))).flatten.distinct.toList
    boxList.filterNot(overlapList.contains(_))
  }

/*
  private def initMap2(filename:String):Array[Array[Char]]= {
    val source = Source.fromFile(filename)
    val map = source.getLines
                    .toList
                    .filterNot(_.isEmpty)
                    .map { line => line.toList.filter(e => e != ' ') }
                    .map(_.toArray)
                    .toArray
    source.close()
    map
  }*/

  private def initMap(lines:List[String]):Array[Array[Char]]= { 

      lines.filterNot(_.isEmpty)
      .map { line => line.toList.filter(e => e != ' ') }
      .map(_.toArray)
      .toArray
  }


  private def xyValid(xy: (Int, Int), map: Array[Array[Char]], visitedMap: Set[(Int, Int)]): Boolean = (xy, map, visitedMap) match {
    case (xy, map, _) if xy._1 < 0 || xy._1 >= map.length => false
    case (xy, map, _) if xy._2 < 0 || xy._2 >= map(0).length => false
    case (xy, map, _) if map(xy._1)(xy._2) == '-' => false
    case (xy, _, visitedMap) if visitedMap.contains(xy._1, xy._2) => false
    case _ => true
  }

  def maxBoundingBox(map: Array[Array[Char]]): Unit = {
    //get indices as tuples
    val xyList = for {i <- map.indices
                      j <- map(0).indices
                      } yield (i, j)

    //get list of MinBox
    val minBoxList = xyList.foldLeft((Nil: List[MinBox], Set[(Int, Int)]())) {
      (tup, item) => {
        map(item._1)(item._2) == '-' || tup._2.contains(item) match {
          case true => tup
          case false => val xx = findMinBox(item, map, tup._2)
                        (xx._1 :: tup._1, xx._2)
        }
      }
    }._1

    if(!minBoxList.isEmpty) {
      val largestBox = maxBox(deleteOverlap(minBoxList))
      printf("""(%d,%d)(%d,%d)""", largestBox.minX + 1, largestBox.minY + 1, largestBox.maxX + 1, largestBox.maxY + 1)
      println
    }

  }

  private def maxBox(lst:List[MinBox]):MinBox={
    val area = (box:MinBox) => (box.maxX- box.minX +1) * (box.maxY - box.minY +1)
    lst.maxBy(area)
  }

  private def findMinBox(xy:(Int, Int), map:Array[Array[Char]], visited:Set[(Int, Int)]): (MinBox, Set[(Int, Int)]) =  {

    val addSurrounding = (x:Int, y:Int) => List( (x-1,y), (x+1,y), (x,y-1),(x,y+1))

    def compareAndReduceBox(box1: MinBox, box2:MinBox):MinBox={
      if (box1 == null) {
        box1
      } else {
        MinBox( Math.min(box1.minX,box2.minX) ,
                Math.min(box1.minY,box2.minY) ,
                Math.max(box1.maxX,box2.maxX) ,
                Math.max(box1.maxY,box2.maxY) )
      }
    }

    @tailrec
    def findMinBoxR(lst:List[(Int, Int)], visitedSet:Set[(Int, Int)])(box:MinBox):(MinBox, Set[(Int, Int)])=  lst match{
      case Nil => Tuple2(box, visitedSet)
      case x::xs  if !xyValid(x, map, visitedSet) => findMinBoxR(xs, Set(x) ++ visitedSet)(box)
      case x::xs  => findMinBoxR(addSurrounding(x._1, x._2):::xs,Set(x) ++ visitedSet )(compareAndReduceBox(box, MinBox(x._1,x._2,x._1,x._2)))
    }
    findMinBoxR(List(xy),visited)(MinBox(xy._1,xy._2,xy._1,xy._2))
  }


  def main(args: Array[String]): Unit = {
    val iter = for(line <- io.Source.stdin.getLines()) yield line
    val lines = iter.toList
    val map = initMap(lines)
    maxBoundingBox(map)

    /*println("Please type the full file path : ")
    val inputFileName = scala.io.StdIn.readLine()
    //val filename = "/Users/siddharth/IntellijProjects/ScalaProject/src/resources/input3.txt"
    val map = initMap2(inputFileName)
    maxBoundingBox(map)*/
  }


}
