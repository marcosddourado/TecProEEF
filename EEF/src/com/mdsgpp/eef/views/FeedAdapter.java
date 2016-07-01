package com.mdsgpp.eef.views;



import com.mdsgpp.eef.R;
import com.mdsgpp.eef.model.Feed;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FeedAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private Feed feed;
	private ViewHolder holder;
	
	static class ViewHolder {
		TextView tvTitle;
		TextView tvCategory;
		TextView tvDescription;
	}

	/**
	 * Constructs the adapter with params
	 * @param context The application context
	 * @param feed The current data feed.
     */
	public FeedAdapter(Context context, Feed feed) {
		this.mInflater = LayoutInflater.from(context);
		this.feed = feed;
	}

	/**
	 * @return Returns the number of items on the feed.
     */
	@Override
	public int getCount() {
		return feed.getFeedItemsSize();
	}

	/**
	 *
	 * @param position Position of the item to be retrieved
	 * @return Returns a specific item on a feed.
     */
	@Override
	public Object getItem(int position) {
		return feed.getFeedItems().get(position);
	}

	/**
	 * Item id is always set to zero.
	 * @param position The item position.
	 * @return Zero.
     */
	@Override
	public long getItemId(int position) {
		return 0;
	}

	/**
	 * Returns the holder view.
	 * @param position The item position
	 * @param convertView Wildcard view object.
	 * @param parent SuperView group.
     * @return The holder view.
     */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			/* if the convertView is null (first ListView item), inflate the layout
			   and create a ViewHolder to carry our TextViews, storing inside the ConvertView */
			convertView = this.mInflater.inflate(R.layout.rss_listview_item , null);
			this.holder = new ViewHolder();
			
			this.holder.tvTitle = (TextView) convertView.findViewById(R.id.textView_rss_title);
			this.holder.tvCategory = (TextView) convertView.findViewById(R.id.textView_rss_category);
			this.holder.tvDescription = (TextView) convertView.findViewById(R.id.textView_rss_description);
			convertView.setTag(this.holder);
			
		} else {
			// if the convertView is already inflated, just takes our ViewHolder back
			this.holder = (ViewHolder) convertView.getTag();
		}
		
		// Set the text to our TextViews
		this.holder.tvTitle.setText(this.feed.getFeedItem(position).getNewsTitle());
		this.holder.tvCategory.setText(this.feed.getFeedItem(position).getNewsCategory());
		this.holder.tvDescription.setText(Html.fromHtml( this.feed.getFeedItem(position)
				.getNewsDescription()));
		
		// at this point, the convertView is full, so we can just return it
		return convertView;
	}

}
