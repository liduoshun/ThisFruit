package com.example.thisfruit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static android.content.ContentValues.TAG;


public class FruitFragment extends Fragment implements FruitActivity.Callback{

    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */

    AudioManager mAudioManager;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    int NUM_OF_FRAGMENT = 17;


    ImageView head;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    FruitMatch fruitMatch = new FruitMatch();


    public static FruitFragment newInstance(int position) {
        FruitFragment myFragment = new FruitFragment();

        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);

        return myFragment;
    }

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fruit_fragment, container, false);


        mAudioManager = (AudioManager) requireActivity().getSystemService(Context.AUDIO_SERVICE);


        final int position = getArguments().getInt("position", 0);
        head = view.findViewById(R.id.handPaint);
        imageView1 = view.findViewById(R.id.matchPaint1);
        imageView2 = view.findViewById(R.id.matchPaint2);
        imageView3 = view.findViewById(R.id.matchPaint3);
        imageView4 = view.findViewById(R.id.matchPaint4);


        head.setImageResource(getImageId(position, 1));

        List<Integer> imageRes = generateRandomInt(position);

        final List<Integer> imageR = new ArrayList<>();

        imageR.add(position);
        imageR.add(imageRes.get(0));
        imageR.add(imageRes.get(1));
        imageR.add(imageRes.get(2));

        Collections.shuffle(imageR);


        imageView1.setImageResource(getImageId(imageR.get(0), 2));
        imageView2.setImageResource(getImageId(imageR.get(1),2));
        imageView3.setImageResource(getImageId(imageR.get(2),2));
        imageView4.setImageResource(getImageId(imageR.get(3),2));

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();
                boolean righ = FruitMatch.isMatch(getImageId(position, 1),getImageId(imageR.get(0), 2));
                right(righ);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();
                boolean righ = FruitMatch.isMatch(getImageId(position, 1),getImageId(imageR.get(1), 2));
                right(righ);// Do something here
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();
                boolean righ = FruitMatch.isMatch(getImageId(position, 1),getImageId(imageR.get(2), 2));
                right(righ);// Do something here
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();
                boolean righ = FruitMatch.isMatch(getImageId(position, 1),getImageId(imageR.get(3), 2));
                right(righ);// Do something here
            }
        });

        return view;
    }

    public int getImageId(int position, int img) {
        int imageId = getResources().getIdentifier("a" + position + img, "drawable", requireActivity().getPackageName());
        return imageId;
    }


    public List<Integer> generateRandomInt(int position) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < NUM_OF_FRAGMENT; i++) {
            list.add(i);
        }

        list.remove(list.indexOf(position));

        Collections.shuffle(list);

        return list;
    }

    private void right(boolean ans){
        if(ans){
            Toast.makeText(this.getContext(), "good job", Toast.LENGTH_SHORT).show();
            focus(R.raw.right);
        }else{
            Toast.makeText(this.getContext(), "try again", Toast.LENGTH_SHORT).show();
            focus(R.raw.wrong);
        }
    }

    private void releaseMediaPlayer() {

        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);

        }
    }

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    @Override
    public void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    @Override
    public void onPause() {
        super.onPause();

        releaseMediaPlayer();
    }

    public void focus(int id){
        int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                // Use the music stream.
                AudioManager.STREAM_MUSIC,
                // Request permanent focus.
                AudioManager.AUDIOFOCUS_GAIN);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            // We have audio focus now.

            // Create and setup the {@link MediaPlayer} for the audio resource associated
            // with the current word
            mMediaPlayer = MediaPlayer.create(this.getContext(),id);

            // Start the audio file
            mMediaPlayer.start();

            // Setup a listener on the media player, so that we can stop and release the
            // media player once the sound has finished playing.
            mMediaPlayer.setOnCompletionListener(mCompletionListener);
        }
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//        } else {
//            releaseMediaPlayer();
//        }
//    }

    @Override
    public void onPageChanged() {
        releaseMediaPlayer();
    }

}
