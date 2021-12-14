package com.home.lab10.task1;

public class Entry<R, P> {
    private CallMsg<R, P> cm;
    private Port<CallMsg<R, P>> cp = new Port<CallMsg<R, P>>();

    public P call(R req) throws InterruptedException {
        Channel<P> clientChan = new Channel<P>();
        cp.send(new CallMsg<R, P>(req, clientChan));
        return clientChan.receive();
    }

    public R accept() throws InterruptedException {
        cm = cp.receive();
        return cm.request;
    }

    public void reply(P res) throws InterruptedException {
        cm.replychan.send(res);
    }

    private class CallMsg<R1, P1> {
        R1 request;
        Channel<P1> replychan;

        CallMsg(R1 m, Channel<P1> c) {
            request = m;
            replychan = c;
        }
    }

}
