package com.company;

public class Main {
  // VARIABLE QUE VOUS POUVEZ MODIFIER

  static int NOMBRE_DE_TRAINS_A = 5;
  static int NOMBRE_DE_TRAINS_B = 5;

  static boolean EXECUTION_RALENTIT = true; // add 1 seconde wait between execution inside a thread

  static boolean ONLY_A = false; // cancel B traces
  static boolean ONLY_B = false; // cancel A traces

  static boolean TRACE_ROUTE_A = true; // show traces for route A
  static boolean TRACE_ROUTE_B = true; // show traces for route B
  static boolean TRACE_ROUTE_AB = true; // show traces for route AB
  static boolean TRACE_ROUTE_ABC = true; // show traces for route ABC

  static boolean TRACE_REPARATION = true; // show traces for reparation
  static boolean TRACE_DELAI = true; // show traces for delai

  /////////////////////////////////////

  public static void main(String[] args) {

    int nbTrack_A = 5;
    int nbTrack_B = 7;

    Thread[] A = new Thread[NOMBRE_DE_TRAINS_A];
    Thread[] B = new Thread[NOMBRE_DE_TRAINS_B];

    // INITIALISER LES TRACKS

    Track_AB track_ab = new Track_AB(NOMBRE_DE_TRAINS_A, NOMBRE_DE_TRAINS_B);
    Track_ABC track_abc = new Track_ABC(NOMBRE_DE_TRAINS_A, NOMBRE_DE_TRAINS_B);

    Track_A[] listTrack_a = new Track_A[nbTrack_A];
    for (int i = 0; i < nbTrack_A; i++) {
      listTrack_a[i] = new Track_A(i + 1, NOMBRE_DE_TRAINS_A);
    }

    Track_B[] listTrack_b = new Track_B[nbTrack_B];
    for (int i = 0; i < nbTrack_B; i++) {
      listTrack_b[i] = new Track_B(i + 1, NOMBRE_DE_TRAINS_B);
    }

    // INITIALISER LES TRAINS AVEC CHACUN LEUR THREAD

    for (int i = 0; i < NOMBRE_DE_TRAINS_A; i++) {
      A[i] = new Thread(new TrainA(i, track_ab, track_abc, listTrack_a));
    }

    for (int i = 0; i < NOMBRE_DE_TRAINS_B; i++) {
      B[i] = new Thread(new TrainB(i, track_ab, track_abc, listTrack_b));
    }

    // LANCER LES THREADS

    for (Thread thread: A) {
      thread.start();
    }

    for (Thread thread: B) {
      thread.start();
    }
  }
}
