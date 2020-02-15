package com.example.majorproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class SendPhotoRecyclerViewAdapter extends RecyclerView.Adapter<SendPhotoRecyclerViewAdapter.ViewHolder> {
    private ArrayList<SendPhoto> sendPhotos;
    private Context context;

    public SendPhotoRecyclerViewAdapter(ArrayList<SendPhoto> sendPhotos, Context context) {
        this.sendPhotos = sendPhotos;
        this.context = context;

//        Calendar c = Calendar.getInstance();
//        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
//        String datetime = dateformat.format(c.getTime());
//        Log.d("Time : ", datetime);
    }


    @NonNull
    @Override
    public SendPhotoRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        Log.d("SendPhotoRecycler : ", sendPhotos.get(1).getImagePath());
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.send_photo_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SendPhotoRecyclerViewAdapter.ViewHolder holder, int position) {
        Log.d("PhotoBindHolder : ", sendPhotos.get(position).getImagePath());
//        Calendar c = Calendar.getInstance();
//        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
//        String datetime = dateformat.format(c.getTime());
//        Log.d("prevTime : ", datetime);
        Bitmap resizeBitmap = null;
        BitmapSizeModify bitmapThread = new BitmapSizeModify(sendPhotos.get(position).getImagePath(), resizeBitmap);
        bitmapThread.start();
//        while(true){
//            if(!bitmapThread.isAlive()){
//                holder.imageView.setImageBitmap(resizeBitmap);
//                holder.checkBox.setChecked(false);
//                break;
//            }
//        }
        try {
            bitmapThread.join();
            resizeBitmap = bitmapThread.getResizeBitmap();
            holder.imageView.setImageBitmap(resizeBitmap);
            holder.checkBox.setChecked(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inSampleSize = 3;
//        Bitmap bitmap = BitmapFactory.decodeFile(sendPhotos.get(position).getImagePath());
//        Bitmap resizeBitmap;
//
//        if(bitmap.getWidth() > bitmap.getHeight()){
//            Matrix matrix = new Matrix();
//            matrix.postRotate(90);
//            resizeBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
//        }
//        else{
//            resizeBitmap = Bitmap.createScaledBitmap(bitmap, 130, 140, true);
//
//        }
//        Calendar c1 = Calendar.getInstance();
//        SimpleDateFormat dateformat1 = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
//        String datetime1 = dateformat1.format(c1.getTime());
//        Log.d("TimeNow : ", datetime1);

    }

    @Override
    public int getItemCount() {
        return sendPhotos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CheckBox checkBox;
        private ImageView imageView;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView)itemView.findViewById(R.id.send_photo_cardview);
            checkBox = (CheckBox)itemView.findViewById(R.id.send_photo_cardview_check);
            imageView = (ImageView)itemView.findViewById(R.id.send_photo_cardview_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Log.d("clickListener", "listen!");
            if(pos != RecyclerView.NO_POSITION){
                if(!checkBox.isChecked()) {
                    Log.d("check!", "yes");
                    checkBox.setChecked(true);
                    sendPhotos.get(pos).setCheck(true);
                    MainActivity.selectList.add(MainActivity.imageList.get(sendPhotos.get(pos).getIndex()));
                }
                else{
                    Log.d("check?", "No");
                    checkBox.setChecked(false);
                    sendPhotos.get(pos).setCheck(false);
                    MainActivity.selectList.remove(MainActivity.imageList.get(sendPhotos.get(pos).getIndex()));
                }
                Log.d("image?List", MainActivity.imageList.get(sendPhotos.get(pos).getIndex()).getName());
//                Log.d("selectList ", MainActivity.selectList.get(0).getName());
            }
        }
    }
}