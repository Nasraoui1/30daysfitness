package com.example.fitness

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fitness.model.Fitness

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FitnessList(
    fitness: List<Fitness>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        itemsIndexed(fitness) { index, fitnessItem ->
            FitnessCard(
                fitness = fitnessItem,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            { isExpanded ->
                if (isExpanded) index else -1
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)

 @Composable
    fun FitnessCard(
        fitness: Fitness,
        modifier: Modifier,
        onToggleDescription: (Boolean) -> Unit
    ) {
    // track if description is expanded or no
     var isExpanded by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = {
                // Toggle the expansion state when the card is clicked
                isExpanded = !isExpanded
                onToggleDescription(isExpanded) }
        ) {
            Column(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )
                )
            {
                //Day .. text
                Text(
                    text = stringResource(fitness.dayRes),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                //sport text
                Text(
                    text = stringResource(fitness.titleRes),
                    style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(start = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                //fitness image
                Image(
                    painter = painterResource(fitness.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Condition to expand the description
                if (isExpanded) {
                    //description text
                    Text(
                        text = stringResource(fitness.descriptionRes),
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier.padding(all = 16.dp)
                    )
                }
            }
        }
    }
