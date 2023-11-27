package game_alphabeta_student;

public class Test {


    public static void main(String[] args) {
        Node nA= new Node("A");
        Node nB= new Node("B");
        Node nC= new Node("C");
        Node nD= new Node("D");
        Node nE= new Node("E",3);
        Node nF= new Node("F",12);
        Node nG= new Node("G",8);
        Node nH= new Node("H",2);
        Node nI= new Node("I",4);
        Node nJ= new Node("J",6);
        Node nK= new Node("K",14);
        Node nL= new Node("L",5);
        Node nM= new Node("M",2);
        nA.addChild(nB);
        nA.addChild(nC);
        nA.addChild(nD);
        nB.addChild(nE);
        nB.addChild(nF);
        nB.addChild(nG);
        nC.addChild(nH);
        nC.addChild(nI);
        nC.addChild(nJ);
        nD.addChild(nK);
        nD.addChild(nL);
        nD.addChild(nM);
        ISearchAlgo algo= new AlphaBetaSearchAlgo();
        algo.execute(nA);
//        System.out.println(nA.getValue());
//        System.out.println(nB.getValue());
//        System.out.println(nD.getValue());
    }

}
