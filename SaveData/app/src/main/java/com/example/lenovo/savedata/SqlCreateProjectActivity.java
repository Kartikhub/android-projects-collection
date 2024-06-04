package com.example.lenovo.savedata;

import android.content.DialogInterface;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.savedata.model.ProjectsDatabaseHelper;

public class SqlCreateProjectActivity extends AppCompatActivity {
private static final String ROW_COUNTERS_AMOUNT_STATE="rowCountersAmount";
    private static final String ROWs_AMOUNT_STATE="rowsAmount";
private SqlCounterViewActivity mRowCounterAmountView;
    private SqlCounterViewActivity mRowsAmountView;
    View.OnClickListener mCreateProjectOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView projectNameView= (TextView) SqlCreateProjectActivity.this.findViewById(R.id.create_project_name);
            String projectName = projectNameView.getText().toString();

            int rowCountersAmount=mRowCounterAmountView.getValue();
            int rowsAmount=mRowsAmountView.getValue();
            ProjectsDatabaseHelper database=new ProjectsDatabaseHelper(SqlCreateProjectActivity.this);
            database.createProject(projectName,rowCountersAmount, rowsAmount);
            finish();
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_create_project);
    mRowsAmountView= (SqlCounterViewActivity) this.findViewById(R.id.rows_amount);
        mRowCounterAmountView= (SqlCounterViewActivity) this.findViewById(R.id.row_counters_amount);
        Button createButton= (Button) this.findViewById(R.id.create_project_create_button);
        createButton.setOnClickListener(mCreateProjectOnClickListener);
        if(savedInstanceState !=null){
            mRowCounterAmountView.setValue(savedInstanceState.getInt(ROW_COUNTERS_AMOUNT_STATE));
            mRowsAmountView.setValue(savedInstanceState.getInt(ROWs_AMOUNT_STATE));
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mRowCounterAmountView.setValue(savedInstanceState.getInt(ROW_COUNTERS_AMOUNT_STATE));
        mRowsAmountView.setValue(savedInstanceState.getInt(ROWs_AMOUNT_STATE));

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(ROW_COUNTERS_AMOUNT_STATE, mRowCounterAmountView.getValue());
        savedInstanceState.putInt(ROWs_AMOUNT_STATE, mRowsAmountView.getValue());
        super.onSaveInstanceState(savedInstanceState);
    }
}
