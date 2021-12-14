package com.home.lab10.task1;

public class Channel<T> {
    private T chan = null;
    int ready = 0;

    public synchronized void send(T mes)
            throws InterruptedException {
        // Copiaza mesajul pe canal
        chan = mes;

        // Instiinteaza receptorii potentiali facand
        // ready = 1
        ++ready;
        notifyAll();

        // Asteapta ca mesajul sa fie preluat de receptor,
        // canalul devenind vid
        while (chan != null) wait();
    }

    public synchronized T receive()
            throws InterruptedException {
        // Asteapta ca un mesaj sa fie disponibil pe canal,
        // cand ready = 1
        while (ready == 0) wait();

        // Copiaza mesajul local, elibereaza canalul si
        // instiinteaza potentialii transmitatori
        --ready;
        T tmp = chan;
        chan = null;
        notifyAll();
        return (tmp);
    }

}
