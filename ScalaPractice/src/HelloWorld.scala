object HelloWorld {
  /* This is my first java program.  
   * This will print 'Hello World' as the output
   */
  def main(args: Array[String]) {
    println("Hello, world!") // prints Hello World

    println(1.+(2));
    main();
    newFunction(callThisFunction);
    println(callThisFunctionWithReturnType);
    callThisFunctionWithArgument(200);
  }

  def callThisFunction() {
    println("calling function as argument");
  }
  def callThisFunctionWithArgument(x: Int) {
    println("calling function with method parameter: " + x);
  }
  def callThisFunctionWithReturnType(): Int = {
    println("calling function with return type and value 100");
    100
  }

  def main() {
    println("duplicate");
  }

  def newFunction(callback: () => Unit) {
    //while (true) {
    callback();
    Thread.sleep(1000);
    //}
  }

  def newFunctionWithReturn(callback: () => Int) {
    while (true) {
      println(callback());
      Thread.sleep(1000);
    }
  }
}