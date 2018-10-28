package pharm.redpharm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class ItemModelAdapter extends RecyclerView.Adapter<ItemModelAdapter.ViewHolder> {
    private static final String LOG_TAG = RecyclerViewAdapter.class.getSimpleName();


    private ArrayList<ItemModel> mItems;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mPrices = new ArrayList<>();


    private Context mContext;

    public static int position;
    private static final String TAG = "ItemModelAdapter";

    public ItemModelAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images , ArrayList<String> prices) {

        mNames = imageNames;
        mImages = images;
        mContext = context;
        mPrices = prices;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        ViewHolder holder = new ViewHolder(view);
        Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position)
    {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.name.setText(mNames.get(position));
        holder.price.setText(mPrices.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mNames.get(position));

                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, ItemDetails.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mNames.get(position));
                intent.putExtra("price", mPrices.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mItems != null) {
            return mNames.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
      //  public CardView cardView;
        public ItemModel pName;
        TextView name;
        TextView price;
        CircleImageView image;
  //      LinearLayout textContainer , text2;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {

            super(itemView);
            //itemView.setOnClickListener(this);
           // cardView = (CardView)itemView.findViewById(R.id.cvItem);
            name = (TextView) itemView.findViewById(R.id.name1);
            price = (TextView) itemView.findViewById(R.id.price1);
            image = itemView.findViewById(R.id.image1);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            //textContainer = itemView.findViewById(R.id.text_container);
          //  text2 = itemView.findViewById(R.id.text2);

        }

      /*  public void setData(ItemModel pName) {
            this.pName = pName;
            name.setText(pName.getItemName());
            price .setText(pName.getItemPrice());

            Glide.with(mContext)
                    .asBitmap()
                    .load(pName.getItemPicture())
                    .into(image);

        }*/
        /*

        @Override
        public void onClick(View v) {

            if (mListener != null) {
                mListener.onItemClick(pName, getAdapterPosition());
            }
            Toast.makeText(context,pName.getItemName(),Toast.LENGTH_SHORT).show();

        }
        */

    }


}