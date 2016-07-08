class Layer {

  private HiddenNode[] nodes;
  private Layer prevLayer;
  private Layer nextLayer;

  private Layer() {
  }

  //Overload constructor
  public Layer(int numNodes, int numInputs) {

    this.nodes = new HiddenNode[numNodes];

    for(int i = 0; i < numNodes; numNodes++) {
      this.nodes = new HiddenNode(numInputs);
    }

  }

  public void giveInputs(double[] inputs) {

      for(HiddenNode node : this.nodes) {
        node.applyInput
      }

  }

  public void setNextLayer(Layer layer) {
    this.nextLayer = layer;
  }

  public void setPrevLayer(Layer layer) {
    this.prevLayer = layer;
  }

  public Layer getNextLayer() {
    return this.nextLayer;
  }

  public Layer getPrevLayer() {
    return this.prevLayer;
  }

  /***
  * Constructs an array of the results of applying the inputs to
  * each HiddenNode in the layer then returns the results in an array
  ****/
  public double[] run(double[] inputs) {
    double[] results = new double[this.nodes.length];

    for(int i = 0; i < this.nodes.length; i++) {
      results[i] = this.nodes[i].run(inputs);
    }

    return results;
  }

}
