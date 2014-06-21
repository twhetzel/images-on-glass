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

	    // Index of api demo cards.
	    // Visible for testing.
	    static final int CARDS = 0;
	    static final int GESTURE_DETECTOR = 1;
	    static final int THEMING = 2;
	    static final int OPENGL = 3;

	    private CardScrollAdapter mAdapter;
	    private CardScrollView mCardScroller;
	    
	    // Visible for testing.
	    CardScrollView getScroller() {
	        return mCardScroller;
	    }
	    
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		//setContentView(R.layout.activity_main);
		mAdapter = new CardAdapter(createCards(this));
        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(mAdapter);
        setContentView(mCardScroller);
        //setCardScrollerListener();  //listens for touch actions when viewing a Card
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

    /**
     * Different type of activities can be shown, when tapped on a card.
     */
    /*private void setCardScrollerListener() {
        mCardScroller.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "Clicked view at position " + position + ", row-id " + id);
                int soundEffect = Sounds.TAP;
                // Includes CASE statements as copied from sample code 
                switch (position) {
                    case CARDS:
                        startActivity(new Intent(MainActivity.this, CardsActivity.class));
                        break;
                        
                    case GESTURE_DETECTOR:
                        startActivity(new Intent(MainActivity.this,
                                SelectGestureDemoActivity.class));
                        break;

                    case THEMING:
                        startActivity(new Intent(MainActivity.this, ThemingActivity.class));
                        break;


                    default:
                        soundEffect = Sounds.ERROR;
                        Log.d(TAG, "Don't show anything");
                }

                // Play sound.
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(soundEffect);
            }
        });
    }*/
}
