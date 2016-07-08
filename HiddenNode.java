/******
* Represents a node in the hidden layer
*******/
class HiddenNode {

  public double[] weights;

  //Cannot use default constructor
  private HiddenNode() {
  }

  //Overload constructor
  //TODO: generate weights
  public HiddenNode(int inputs) {
    this.weights = new int[inputs + 1];
  }

  /**
  * Applies weights to the inputs and sums them
  ***/
  public double run(int[] inputs) {
    double results = 0;

    for(int i = 0; i < inputs.length; i++) {
      results += weights[i] * inputs[i];
    }

    return results;
  }

}
