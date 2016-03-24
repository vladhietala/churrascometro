package vlad.com.br.churrascometro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar sbMen, sbWomen, sbKids;
    TextView tvMen, tvWomen, tvKids, tvSausage, tvMeat;
    private SeekBar.OnSeekBarChangeListener seekBarListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    System.out.println(sbMen.getProgress());
                    tvMen.setText(String.valueOf(sbMen.getProgress()));
                    tvWomen.setText(String.valueOf(sbWomen.getProgress()));
                    tvKids.setText(String.valueOf(sbKids.getProgress()));
                    calculate(sbMen.getProgress(), sbWomen.getProgress(), sbKids.getProgress());
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        sbMen = (SeekBar) findViewById(R.id.seekBarMen);
        sbWomen = (SeekBar) findViewById(R.id.seekBarWomen);
        sbKids = (SeekBar) findViewById(R.id.seekBarKids);
        tvMen = (TextView) findViewById(R.id.textViewSBMen);
        tvWomen = (TextView) findViewById(R.id.textViewSBWomen);
        tvKids = (TextView) findViewById(R.id.textViewSBKids);

        System.out.println(tvMen.getText());
        System.out.println(tvWomen.getText());
        System.out.println(tvKids.getText());

        sbMen.setOnSeekBarChangeListener(seekBarListener);
        sbWomen.setOnSeekBarChangeListener(seekBarListener);
        sbKids.setOnSeekBarChangeListener(seekBarListener);
    }

    private void calculate(int men, int women, int kids) {
        int sausage, meat;
        float sausageResult, meatResult;

        tvSausage = (TextView) findViewById(R.id.textViewSausage);
        tvMeat = (TextView) findViewById(R.id.textViewMeat);

        sausage = men * 450 + women * 250 + kids * 200;
        sausageResult = (float) sausage / 1000;
        meat = men * 500 + women * 300 + kids * 200;
        meatResult = (float) meat / 1000;

        tvSausage.setText(String.format("%.2f", sausageResult));
        tvMeat.setText(String.format("%.2f", meatResult));
    }

}
