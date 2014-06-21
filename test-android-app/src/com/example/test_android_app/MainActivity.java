package com.example.test_android_app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.List;



/**
 * Creates a card scroll view with Cards with different images.
 *
 * <ol>
 * <li> Cards
 * </ol>
 */
public class MainActivity extends Activity {
	private static final String TAG = MainActivity.class.getSimpleName();

	// Api demo card - instructions 
	static final int CARDS = 0;

	private CardScrollAdapter mAdapter;
	private CardScrollView mCardScroller;

	// Visible for testing.
	CardScrollView getScroller() {
		return mCardScroller;
	}

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		mAdapter = new CardAdapter(createCards(this));
		mCardScroller = new CardScrollView(this);
		mCardScroller.setAdapter(mAdapter);
		setContentView(mCardScroller);
	}

	/**
	 * Create list of API demo cards.
	 */
	private List<Card> createCards(Context context) {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(CARDS, new Card(context).setText(R.string.text_cards));


		//Create cards with single image
		Card onto_tax = new Card(context);
		onto_tax.setImageLayout(Card.ImageLayout.FULL);
		onto_tax.addImage(R.drawable.glass_edu_bw_rs);
		cards.add(onto_tax);

		Card card_cpr = new Card(context);
		card_cpr.setImageLayout(Card.ImageLayout.FULL);
		card_cpr.addImage(R.drawable.ev_patient);
		cards.add(card_cpr);

		Card card_ev = new Card(context);
		card_ev.setImageLayout(Card.ImageLayout.FULL);
		card_ev.addImage(R.drawable.sv_images);
		cards.add(card_ev);

		return cards;
	}

	@Override
	protected void onResume() {
		super.onResume();
		mCardScroller.activate();
	}

	@Override
	protected void onPause() {
		mCardScroller.deactivate();
		super.onPause();
	}
}
