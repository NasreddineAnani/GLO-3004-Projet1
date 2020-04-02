package com.company;

import static com.company.Main.ONLY_B;
import static com.company.Main.TRACE_DELAI;
import static com.company.Main.TRACE_REPARATION;
import static com.company.Main.TRACE_ROUTE_A;

public class Track_A {

  boolean occupied = false;
  int order = 0;
  int trackId;
  int nbTrain;

  int panneId;

  public Track_A(int trackId, int nbTrain) {
    this.trackId = trackId;
    this.nbTrain = nbTrain;
  }

  synchronized void AEnter(int id) throws InterruptedException {
    while (occupied || this.order != id) {
      wait();
    }
    occupied = true;
    if (TRACE_ROUTE_A && !ONLY_B) {
      System.out.println("Train A" + id + " enter track A" + this.trackId);
    }
  }

  synchronized void AExit(int id){
    occupied = false;
    order = (id + 1)%this.nbTrain;
    notifyAll();
    if (TRACE_ROUTE_A && !ONLY_B) {
      System.out.println("Train A" + id + " exit track A" + this.trackId);
    }
  }

  synchronized void ADelai(int id) throws InterruptedException {
    if (TRACE_DELAI && TRACE_ROUTE_A && !ONLY_B) {
      System.out.println("Train A" + id + " delai track A" + this.trackId);
    }
  }

  synchronized void APanne(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_A && !ONLY_B) {
      System.out.println("Train A" + id + " panne track A" + this.trackId);
    }
    AReparation(id);
  }

  synchronized void AReparation(int id) throws InterruptedException {
    if (TRACE_REPARATION && TRACE_ROUTE_A && !ONLY_B) {
      System.out.println("Train A" + id + " reparation track A" + this.trackId);
    }
  }
}
