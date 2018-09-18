package tz.co.aim.volleylistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import tz.co.aim.volleylistview.model.Movie;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_card,viewGroup,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.tv_name.setText(mData.get(position).getName());
        myViewHolder.tv_rating.setText(mData.get(position).getRatings());
        myViewHolder.tv_category.setText(mData.get(position).getCategories());
        myViewHolder.tv_studio.setText(mData.get(position).getStudio());



//        Making Glide Request option

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);



//        Loading Images from a URL

        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(myViewHolder.image_url);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tv_name;
        TextView tv_rating;
        TextView tv_category;
        TextView tv_studio;
        ImageView image_url;
        RatingBar mRatingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_name = itemView.findViewById(R.id.movie_name);
            tv_rating = itemView.findViewById(R.id.ratings);
            tv_category = itemView.findViewById(R.id.categories);
            tv_studio = itemView.findViewById(R.id.studio);
            image_url = itemView.findViewById(R.id.thumbnail);
            mRatingBar = itemView.findViewById(R.id.rating_bar);
        }
    }
}
