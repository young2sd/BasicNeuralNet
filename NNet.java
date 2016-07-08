import java.util.*;
/****
* Represents the net as a whole
****/
class NNet {

  private int layers;
  private int inputs;
  private Layer firstLayer;

  // Overload constructor
  public NNet(int numInputs, int layers, int[] nodesInLayer) {

      if(nodesInLayer.length != layers) {
        //TODO: Consider if there are less nodes/more nodes
        System.out.println("Unspecified layers will be given 5 nodes.");
      }

      this.inputs = numInputs;
      this.firstLayer = new Layer(nodesInLayer[0], inputs);
      Layer currentLayer = this.firstLayer;
      Layer lastLayer = null;

      //Actually constructs and stitches together the layers
      for(int i = 1; i < layers; i++) {
          lastLayer = currentLayer;
          currentLayer = new Layer(nodesInLayer[i], inputs);
          lastLayer.setNextLayer(lastLayer);
          currentLayer.setPrevLayer(lastLayer);
      }

  }

  //Run the Neural Net on the provided inputs
  public void run(int[] inputs) throws InputMismatchException {

    if(inputs.length != this.inputs) {
      throw new InputMismatchException();
    }

    //Pass the inputs to first layer, then results to each layer to the
    // Next layer
    double[] curInput = inputs;
    Layer curLayer = this.firstLayer;

    while(curLayer != null) {
      curInput = curLayer.run(curInput);
      curLayer = curLayer.getNextLayer();
    }

    //Now the last set of inputs is stored in curInput

  }

}
