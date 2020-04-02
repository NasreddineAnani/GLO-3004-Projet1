package com.company;

import static com.company.Main.ONLY_A;
import static com.company.Main.TRACE_DELAI;
import static com.company.Main.TRACE_REPARATION;
import static com.company.Main.TRACE_ROUTE_B;

public class Track_B {

  boolean occupied = false;
  int order = 0;
  int trackId;
  int nbTrain;

  public Track_B(int trackId, int nbTrain) {
    this.trackId = trackId;
    this.nbTrain = nbTrain;
  }

  synchronized void BEnter(int id) throws InterruptedException {
    while (occupied || this.order != id) {
      wait();
    }
    occupied = true;
    if (TRACE_ROUTE_B && !ONLY_A) {
      System.out.println("Train B" + id + " enter track B" + this.trackId);
    }
  }

  synchronized void BExit(int id){
    occupied = false;
    order = (id + 1)%this.nbTrain;
    notifyAll();
    if (TRACE_ROUTE_B && !ONLY_A) {
      System.out.println("Train B" + id + " exit track B" + this.trackId);
    }
  }

  synchronized void BDelai(int id) throws InterruptedException {
    if (TRACE_ROUTE_B && TRACE_DELAI && !ONLY_A) {
      System.out.println("Train B" + id + " delai track B" + trackId);
    }
  }

  synchronized void BPanne(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_B && !ONLY_A) {
      System.out.println("Train B" + id + " panne track B" + this.trackId);
    }
    BReparation(id);
  }

  synchronized void BReparation(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_B && !ONLY_A) {
      System.out.println("Train B" + id + " reparation track B" + this.trackId);
    }
  }
}
