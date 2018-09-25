package com.example.hp.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

    public class WordAdapter extends ArrayAdapter<Word> {

        /** Resource ID for the background color for this list of words */
        private int mColorResourceId;


        private static final String LOG_TAG = WordAdapter.class.getSimpleName();

        /**
         * This is our own custom constructor (it doesn't mirror a superclass constructor).
         * The context is used to inflate the layout file, and the list is the data we want
         * to populate into the lists.
         *
         * @param context        The current context. Used to inflate the layout file.
         * @param words A List of Word objects to display in a list
         */
        public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
            // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
            // the second argument is used when the ArrayAdapter is populating a single TextView.
            // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
            // going to use this second argument, so it can be any value. Here, we used 0.
            super(context, 0, words);
            mColorResourceId = colorResourceId;

        }
        /**
         * Provides a view for an AdapterView (ListView, GridView, etc.)
         *
         * @param position The position in the list of data that should be displayed in the
         *                 list item view.
         * @param convertView The recycled view to populate.
         * @param parent The parent ViewGroup that is used for inflation.
         * @return The View for the position in the AdapterView.
         */

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            // Check if the existing view is being reused, otherwise inflate the view
            View listView = convertView;
            if(listView == null) {
                listView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
                //   return super.getView(0, convertView, parent);
            }

            // Get the {@link AndroidFlavor} object located at this position in the list
            Word currentWord;
            currentWord = getItem(position);

            // Find the TextView in the list_item.xml layout with the Miwok_text_view(ID version_name)
            TextView miwokTextView = (TextView) listView.findViewById(R.id.miwok_text_view);
            // Get the miwok (version name) from the current Word(AndroidFlavor) object and
            // set this text on the miwok(name) TextView
            miwokTextView.setText(currentWord.getMiwokTranslation());

            // Find the TextView in the list_item.xml layout with the default_text_view(ID version_number)
            TextView defaultTextView = (TextView) listView.findViewById(R.id.default_text_view);
            // Get the default(version number) from the current Word (AndroidFlavor) object and
            // set this text on the default(number) TextView
            defaultTextView.setText(currentWord.getDefaultTranslation());

            // Find the ImageView in the list_item.xml layout with the ID list_item_icon
             ImageView imageView = (ImageView) listView.findViewById(R.id.image);

            // Check if an image is provided for this word or not
            if (currentWord.hasImage()) {
                // If an image is available, display the provided image based on the resource ID
                imageView.setImageResource(currentWord.getImageResourceId());
                // Make sure the view is visible
                imageView.setVisibility(View.VISIBLE);
            } else {
                // Otherwise hide the ImageView (set visibility to GONE)
                imageView.setVisibility(View.GONE);
            }

            // Set the theme color for the list item
            View textContainer = listView.findViewById(R.id.text_container);
            // Find the color that the resource ID maps to
            int color = ContextCompat.getColor(getContext(), mColorResourceId);
            // Set the background color of the text container View
            textContainer.setBackgroundColor(color);

            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listView;

        }
    }
