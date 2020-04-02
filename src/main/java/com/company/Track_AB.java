package com.company;

import static com.company.Main.ONLY_A;
import static com.company.Main.ONLY_B;
import static com.company.Main.TRACE_DELAI;
import static com.company.Main.TRACE_REPARATION;
import static com.company.Main.TRACE_ROUTE_A;
import static com.company.Main.TRACE_ROUTE_AB;
import static com.company.Main.TRACE_ROUTE_B;

public class Track_AB {

  private int nA = 0;
  private int nB = 0;
  int nbTrainA;
  int nbTrainB;

  int orderA = 0;
  int orderB = 0;

  public Track_AB(int nbTrainA, int nbTrainB) {
    this.nbTrainA = nbTrainA;
    this.nbTrainB = nbTrainB;
  }

  synchronized void AEnter(int id) throws InterruptedException {
    while (nB>0 || this.orderA != id) {
      if (TRACE_ROUTE_AB && !ONLY_B) {
        System.out.println("Train A" + id + " waiting track AB");
      }
      wait();
    };
    ++nA;
    if (TRACE_ROUTE_AB && !ONLY_B) {
      System.out.println("Train A" + id + " enter track AB");
    }
  }

  synchronized void AExit(int id){
    --nA;
    orderA = (id + 1)%this.nbTrainA;
    if (nA==0)
      notifyAll();
    if (TRACE_ROUTE_AB && !ONLY_B) {
      System.out.println("Train A" + id + " exit track AB");
    }
  }

  synchronized void ADelai(int id) throws InterruptedException {
    if (TRACE_DELAI && TRACE_ROUTE_AB && !ONLY_B) {
      System.out.println("Train A" + id + " delai track AB");
    }
    wait();
    notifyAll();
  }

  synchronized void BEnter(int id) throws InterruptedException {
    while (nA>0 || this.orderB != id) {
      if (TRACE_ROUTE_AB && !ONLY_A) {
        System.out.println("Train B" + id + " waiting track AB");
      }
      wait();
    };
    ++nB;
    if (TRACE_ROUTE_AB && !ONLY_A) {
      System.out.println("Train B" + id + " enter track AB");
    }
  }

  synchronized void BExit(int id){
    --nB;
    orderB = (id + 1)%this.nbTrainB;
    if (nB==0)
      notifyAll();
    if (TRACE_ROUTE_AB && !ONLY_A) {
      System.out.println("Train B" + id + " exit track AB");
    }
  }

  synchronized void BDelai(int id) throws InterruptedException {
    if (TRACE_ROUTE_AB && TRACE_DELAI && !ONLY_A) {
      System.out.println("Train B" + id + " delai track AB");
    }
  }

  synchronized void BPanne(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_B && !ONLY_A) {
      System.out.println("Train B" + id + " panne track AB");
    }
    BReparation(id);
  }

  synchronized void BReparation(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_B && !ONLY_A) {
      System.out.println("Train B" + id + " reparation track AB");
    }
  }

  synchronized void APanne(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_A && !ONLY_B) {
      System.out.println("Train A" + id + " panne track AB");
    }
    AReparation(id);
  }

  synchronized void AReparation(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_A && !ONLY_B) {
      System.out.println("Train A" + id + " reparation track AB");
    }
  }
}
