package com.problemhunt.shailendra;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.problemhunt.shailendra.adapter.AboutCountryAdapter;
import com.problemhunt.shailendra.models.AboutModel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.IsNull.notNullValue;



@RunWith(AndroidJUnit4.class)
public class GetFactTest {

    private static final long WAIT = 10000;

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    /**
     * A unit test to check if downloaded data is added to the {@link RecyclerView}.
     *
     * @throws InterruptedException
     * @throws NoSuchFieldException
     */
    @Test
    public void testFactDownloaded() throws InterruptedException, NoSuchFieldException {

        MainActivity activity = rule.getActivity();

        View viewById = activity.findViewById(R.id.rv_facts);

        assertThat(viewById, notNullValue());

        RecyclerView listView = (RecyclerView) viewById;
        AboutCountryAdapter adapter = (AboutCountryAdapter) listView.getAdapter();

        assertThat(adapter, instanceOf(RecyclerView.Adapter.class));

        if (Utils.isNetworkAvailable(activity)) {
            Thread.sleep(WAIT);
            assertThat(adapter.getItemCount(), greaterThan(5));
        }
    }

    /**
     * A unit test to check if the data was not yet downloaded.
     *
     * @throws InterruptedException
     * @throws NoSuchFieldException
     */
    @Test
    public void testFactDownloadFailed() throws InterruptedException, NoSuchFieldException {

        MainActivity activity = rule.getActivity();

        View viewById = activity.findViewById(R.id.rv_facts);

        assertThat(viewById, notNullValue());

        RecyclerView listView = (RecyclerView) viewById;
        AboutCountryAdapter adapter = (AboutCountryAdapter) listView.getAdapter();

        assertThat(adapter, instanceOf(RecyclerView.Adapter.class));

        if (Utils.isNetworkAvailable(activity)) {
            activity.loadRecyclerView(new ArrayList<AboutModel>());
            assertThat(adapter.getItemCount(), lessThanOrEqualTo(0));
        }
    }
}