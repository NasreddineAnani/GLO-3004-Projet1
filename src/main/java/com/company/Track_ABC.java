package com.company;

import static com.company.Main.ONLY_A;
import static com.company.Main.ONLY_B;
import static com.company.Main.TRACE_DELAI;
import static com.company.Main.TRACE_REPARATION;
import static com.company.Main.TRACE_ROUTE_A;
import static com.company.Main.TRACE_ROUTE_ABC;
import static com.company.Main.TRACE_ROUTE_B;

public class Track_ABC {

  private int nA = 0;
  private int nB = 0;

  int nbTrainA;
  int nbTrainB;

  int orderA = 0;
  int orderB = 0;

  public Track_ABC(int nbTrainA, int nbTrainB) {
    this.nbTrainA = nbTrainA;
    this.nbTrainB = nbTrainB;
  }

  synchronized void AEnter(int id) throws InterruptedException {
    while (nB>0 || this.orderA != id) {
      if (TRACE_ROUTE_ABC && !ONLY_B) {
        System.out.println("Train A" + id + " waiting track ABC");
      }
      wait();
    };
    ++nA;
    if (TRACE_ROUTE_ABC && !ONLY_B) {
      System.out.println("Train A" + id + " enter track ABC");
    }
  }

  synchronized void AExit(int id){
    --nA;
    orderA = (id + 1)%this.nbTrainA;
    if (nA==0)
      notifyAll();
    if (TRACE_ROUTE_ABC && !ONLY_B) {
      System.out.println("Train A" + id + " exit track ABC");
    }
  }


  synchronized void ADelai(int id) throws InterruptedException {
    if (TRACE_ROUTE_ABC && TRACE_DELAI && !ONLY_B) {
      System.out.println("Train A" + id + " delai track ABC");
    }
    wait();
    notifyAll();
  }

  synchronized void BEnter(int id) throws InterruptedException {
    while (nA>0 || this.orderB != id) {
      if (TRACE_ROUTE_ABC && !ONLY_A) {
        System.out.println("Train B" + id + " waiting track ABC");
      }
      wait();
    };
    ++nB;
    if (TRACE_ROUTE_ABC && !ONLY_A) {
      System.out.println("Train B" + id + " enter track ABC");
    }
  }

  synchronized void BExit(int id){
    --nB;
    orderB = (id + 1)%this.nbTrainB;
    if (nB==0)
      notifyAll();
    if (TRACE_ROUTE_ABC && !ONLY_A) {
      System.out.println("Train B" + id + " exit track ABC");
    }
  }

  synchronized void BDelai(int id) {
    if (TRACE_ROUTE_ABC && TRACE_DELAI && !ONLY_A) {
      System.out.println("Train B" + id + " delai track ABC");
    }
  }

  synchronized void BPanne(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_B && !ONLY_A) {
      System.out.println("Train B" + id + " panne track ABC");
    }
    BReparation(id);
  }

  synchronized void BReparation(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_B && !ONLY_A) {
      System.out.println("Train B" + id + " reparation track ABC");
    }
  }

  synchronized void APanne(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_A && !ONLY_B) {
      System.out.println("Train A" + id + " panne track ABC");
    }
    AReparation(id);
  }

  synchronized void AReparation(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_A && !ONLY_B) {
      System.out.println("Train A" + id + " reparation track ABC");
    }
  }
}
