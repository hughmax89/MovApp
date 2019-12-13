package com.hgs.data.internet;

import android.content.Context;
import android.os.AsyncTask;

import com.hgs.data.internet.command.ICommand;
import com.hgs.data.internet.model.request.RequestModelCustom;
import com.hgs.data.internet.model.response.ResponseModelCustom;

public class GeneralRequestTask extends AsyncTask<RequestModelCustom, Integer, ResponseModelCustom> {

    private final ICommand iCommand;
    private final Context context;

    public GeneralRequestTask(
        ICommand iCommand,
        Context context) {

        this.iCommand = iCommand;
        this.context = context;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected ResponseModelCustom doInBackground(RequestModelCustom... params) {
        try {
            RequestModelCustom requestModelCustom = params[0];

            return iCommand.doWork(requestModelCustom);
        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseModelCustom(false,e.getMessage());
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ResponseModelCustom responseModelCustom) {

        iCommand.doFinish(responseModelCustom);

        super.onPostExecute(responseModelCustom);
    }
}
